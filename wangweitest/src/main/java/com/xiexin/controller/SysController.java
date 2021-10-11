package com.xiexin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiexin.bean.SysLog;
import com.xiexin.bean.SysLogExample;
import com.xiexin.respcode.Result;
import com.xiexin.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/syslog")
public class SysController {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("/selectAll")
    public Result selectAll(){
        List<SysLog> sysLogs = sysLogService.selectByExample(null);
        Result result = new Result(sysLogs);
        return result;
    }
    //带参数的分页查询
    @RequestMapping("/selectPageAll")
    public Result selectPageAll(SysLog sysLog,@RequestParam(value = "page",defaultValue = "1",required = true) Integer page,
                                @RequestParam(value = "limit",defaultValue = "10",required = true) Integer pageSize){

        SysLogExample example = new SysLogExample();
        SysLogExample.Criteria criteria = example.createCriteria();
        //使用pagehelper分页
        PageHelper.startPage(page,pageSize);
        if(null!=sysLog.getEventType()&&!"".equals(sysLog.getEventType())){
            criteria.andEventTypeEqualTo(sysLog.getEventType());

        }
        if(null!=sysLog.getCategoryId()&&!"".equals(sysLog.getCategoryId())){
            criteria.andCategoryIdEqualTo(sysLog.getCategoryId());
        }
//        if(null!=sysLog.getEventTime()&&!"".equals(sysLog.getEventTime())){
//            criteria.andEventTimeEqualTo(sysLog.getEventTime());
//        }
        List<SysLog> sysLogs = sysLogService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(sysLogs);
        Result result = new Result(pageInfo);
        return result;
    }
}
