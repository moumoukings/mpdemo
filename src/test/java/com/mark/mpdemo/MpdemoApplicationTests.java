package com.mark.mpdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mark.mpdemo.domain.request.dto.UserReqDto;
import com.mark.mpdemo.mapper.UserReqDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest()
@Slf4j
public class MpdemoApplicationTests {

    @Autowired
    private UserReqDtoMapper userReqDtoMapper;

    @Test
    public void testSelectList() {
        System.out.println("--------------selectAll method test---------------");
        List<UserReqDto> userReqDtoList = userReqDtoMapper.selectList(null);
        userReqDtoList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        System.out.println("--------------insert method test---------------");
        UserReqDto userReqDto = new UserReqDto();
        //userReqDto.setId(7L);
        userReqDto.setName("莫德凯撒");
        userReqDto.setAge(12);
        userReqDto.setEmail("GG@163.com");
        //自动填充

        //userReqDto.setCreatTime(new Date());
        //userReqDto.setUpdateTime(new Date());
        int insert = userReqDtoMapper.insert(userReqDto);
        System.out.println(insert);
    }

    @Test
    public void testUpdateById() {
        System.out.println("--------------updateById method test---------------");
        UserReqDto userReqDto = new UserReqDto();
        userReqDto.setId(7L);
        //userReqDto.setName("GG");
        userReqDto.setAge(11);
        //userReqDto.setEmail("GG@163.com");
        int row = userReqDtoMapper.updateById(userReqDto);
        System.out.println(row);
    }

    //测试乐观锁
   /* @Test
    public void testOptimisticLock() {
        System.out.println("--------------OptimisticLock method test---------------");
        //根据id先查询数据
        UserReqDto userReqDto = userReqDtoMapper.selectById(7L);
        //进行修改
        userReqDto.setAge(361);
        log.info("userReqDto===>"+userReqDto);
        userReqDtoMapper.updateById(userReqDto);
        //userReqDtoMapper.update(userReqDto,null);
        //System.out.println(row);
    }*/

    //多个id批量查询
    @Test
    public void testselectBatchIds(){
        List<Long> list = new ArrayList();
        list.add(0,1L);
        list.add(1,2L);
        list.add(2,3L);
        //List<UserReqDto> userReqDtoList = userReqDtoMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        List<UserReqDto> userReqDtoList = userReqDtoMapper.selectBatchIds(list);
        userReqDtoList.forEach(System.out::println);
    }

    /**
     * 分页查询
     */
    @Test
    public void testPageSelect(){
        Page<UserReqDto> page = new Page<>(1,3);

        page = userReqDtoMapper.selectPage(page, null);

        //当前页
        System.out.println("当前页"+page.getCurrent());
        //每页数据list
        System.out.println("每页数据list"+page.getRecords());
        //每页数量
        System.out.println("每页数量"+page.getSize());
        //总记录数
        System.out.println("总记录数"+page.getTotal());
        //总页数
        System.out.println("总页数"+page.getPages());

        //下一页
        System.out.println("是否有下一页"+page.hasNext());
        //上一页
        System.out.println("是否有上一页"+page.hasPrevious());

        System.out.println("dsda"+page.getOrders());
    }

    /**
     * 逻辑删除
     */
    @Test
    public void testLogicDelete() {
        int row = userReqDtoMapper.deleteById(7L);
        System.out.println(row);
    }

    /**
     * 测试 逻辑删除后的查询
     */
    @Test
    public void testLogicDeleteSelect() {
        //UserReqDto userReqDto = new UserReqDto();
        List<UserReqDto> userReqDtoList = userReqDtoMapper.selectList(null);
        userReqDtoList.forEach(System.out::println);
    }

    /**
     * 测试 复杂条件查询
     */
    @Test
    public void testWrapperQuery() {
        QueryWrapper<UserReqDto> queryWrapper = new QueryWrapper();

        //通过queryWrapper设置条件
        //ge gt le lt
        queryWrapper.ge(true,"age","30");
        queryWrapper.likeRight(true,"email","G");
        List<UserReqDto> userReqDtoList = userReqDtoMapper.selectList(queryWrapper);
        userReqDtoList.forEach(System.out::println);
    }


}
