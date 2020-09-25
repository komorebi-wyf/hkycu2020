package com.wyf.ycu.mybatis.mapper;

import com.wyf.ycu.mybatis.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    /** 查询所有的客户 */
    List<Customer> getAll();

    /** 根据id查询 */
    Customer getOne(Long id);

    /** 增加客户 */
    void insert(Customer customer);

    /** 更新客户 */
    void update(Customer customer);

    /** 删除客户 */
    void delete(Long id);

}
