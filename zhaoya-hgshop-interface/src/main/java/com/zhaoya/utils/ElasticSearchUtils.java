package com.zhaoya.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchUtils<T> {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	/**
	 * ����͸�������
	 * 
	 * 
	 * @param id
	 * @param object
	 */
	public void saveObject(String id, T t) {
		// �������Զ���
		IndexQuery query = new IndexQueryBuilder().withId(id).withObject(t).build();
		// ��������
		elasticsearchTemplate.index(query);
	}

	/**
	 * ����ɾ��
	 * 
	 * 
	 * @param clazz
	 * @param ids
	 */
	public void deleteObject(Class<T> clazz, Integer ids[]) {
		for (Integer id : ids) {
			// ��������
			elasticsearchTemplate.delete(clazz, id.toString());

		}
	}

	/**
	 * 
	 * @Title: selectById
	 * @Description: ����id��es�������в�ѯ����
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 * @return: Object
	 */
	public Object selectById(Class<T> clazz, Integer id) {
		GetQuery query = new GetQuery();
		query.setId(id.toString());
		return elasticsearchTemplate.queryForObject(query, clazz);
	}

	// ��ѯ����
	public AggregatedPage<T> queryObjects(
			// ElasticsearchTemplate elasticsearchTemplate,
			Class<T> clazz, Integer page, Integer rows, String fieldNames[], String value) {

		AggregatedPage<T> pageInfo = null;
		// ����Pageable����
		Pageable pageable = PageRequest.of(page - 1, rows, Sort.by(Sort.Direction.ASC, "_id"));
		// ��ѯ����
		SearchQuery query = null;
		// ��ѯ���������Ĺ�������
		QueryBuilder queryBuilder = null;

		if (value != null && !"".equals(value)) {
			// ����ƴ�ӵ�ǰ׺���׺
			String preTags = "<font color=\"red\">";
			String postTags = "</font>";

			// ���崴�������Ĺ������϶���
			HighlightBuilder.Field highlightFields[] = new HighlightBuilder.Field[fieldNames.length];

			for (int i = 0; i < fieldNames.length; i++) {
				// �������������
				highlightFields[i] = new HighlightBuilder.Field(fieldNames[i]).preTags(preTags).postTags(postTags);
			}

			// ����queryBuilder����
			queryBuilder = QueryBuilders.multiMatchQuery(value, fieldNames);
			query = new NativeSearchQueryBuilder().withQuery(queryBuilder).withHighlightFields(highlightFields)
					.withPageable(pageable).build();

			pageInfo = elasticsearchTemplate.queryForPage(query, clazz, new SearchResultMapper() {

				@Override
				public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {

					List<T> content = new ArrayList<T>();
					long total = 0l;

					try {
						// ��ѯ���
						SearchHits hits = response.getHits();
						if (hits != null) {
							// ��ȡ�ܼ�¼��
							total = hits.getTotalHits();
							// ��ȡ�������
							SearchHit[] searchHits = hits.getHits();
							// �жϽ��
							if (searchHits != null && searchHits.length > 0) {
								// �������
								for (int i = 0; i < searchHits.length; i++) {
									// ����ֵ
									T entity = clazz.newInstance();

									// ��ȡ����Ľ��
									SearchHit searchHit = searchHits[i];

									// ��ȡ��������е��ֶ�
									Field[] fields = clazz.getDeclaredFields();

									// �����ֶζ���
									for (int k = 0; k < fields.length; k++) {
										// ��ȡ�ֶζ���
										Field field = fields[k];
										// ��������
										field.setAccessible(true);
										// �ֶ�����
										String fieldName = field.getName();
										if (!fieldName.equals("serialVersionUID") && !fieldName.equals("user")) {
											HighlightField highlightField = searchHit.getHighlightFields()
													.get(fieldName);
											if (highlightField != null) {
												// ���� ���� �õ� ��<font color='red'> </font>��������Χ�����ݲ���
												String value = highlightField.getFragments()[0].toString();
												// ע��һ�����Ƿ��� string����
												field.set(entity, value);
											} else {
												// ��ȡĳ���ֶζ�Ӧ�� valueֵ
												Object value = searchHit.getSourceAsMap().get(fieldName);
												System.out.println(value);
												// ��ȡ�ֶε�����
												Class<?> type = field.getType();
												if (type == Date.class) {
													// bug
													if (value != null) {
														field.set(entity, new Date(Long.valueOf(value + "")));
													}
												} else {
													field.set(entity, value);
												}
											}
										}
									}

									content.add(entity);
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					return new AggregatedPageImpl<>(content, pageable, total);
				}

			});

		} else {
			// û�в�ѯ�����ĵ�ʱ�򣬻�ȡes�е�ȫ������ ��ҳ��ȡ
			query = new NativeSearchQueryBuilder().withPageable(pageable).build();
			pageInfo = elasticsearchTemplate.queryForPage(query, clazz);
		}

		return pageInfo;
	}

}
