package com.nowcoder.community.dao.elasticsearch;

import com.nowcoder.community.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author coolsen
 * @version 1.0.0
 * @ClassName DiscussPostRepository.java
 * @Description DiscussPost Repository
 * @createTime 2020/5/19 14:14
 */

@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost,Integer> {
}
