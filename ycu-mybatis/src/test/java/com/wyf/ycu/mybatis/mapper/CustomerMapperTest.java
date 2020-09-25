package com.wyf.ycu.mybatis.mapper;

import com.wyf.ycu.mybatis.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerMapperTest {
    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void testInsert() throws Exception {
        this.customerMapper.insert(new Customer("张三", "zs123456", "M"));
        this.customerMapper.insert(new Customer("天天", "tt123456", "F"));
        this.customerMapper.insert(new Customer("小刚", "xg123456", "M"));

        Assert.assertEquals(3, this.customerMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<Customer> customerList = this.customerMapper.getAll();
        if(customerList == null || customerList.size() == 0) {
            System.out.println("没有数据");
        }else {
            System.out.println(customerList.toString());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        Customer customer = this.customerMapper.getOne(13L);
        System.out.println(customer);

        customer.setNickName("尼奥");

        this.customerMapper.update(customer);

        Assert.assertTrue("尼奥".equals(this.customerMapper.getOne(13L).getNickName()));
    }



}

