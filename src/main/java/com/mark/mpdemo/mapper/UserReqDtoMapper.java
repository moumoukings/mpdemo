package com.mark.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mark.mpdemo.domain.request.dto.UserReqDto;
import org.springframework.stereotype.Repository;

/**
 * 用户接口
 *
 * @author zhangzichen
 * @date 2020/11/09 14:13
 */
@Repository
public interface UserReqDtoMapper extends BaseMapper<UserReqDto> {
}
