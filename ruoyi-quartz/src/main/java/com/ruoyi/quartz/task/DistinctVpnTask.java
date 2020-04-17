package com.ruoyi.quartz.task;

//import com.ruoyi.forts.service.ITokenXkstaffDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("distinctVpnTask")
public class DistinctVpnTask {

    protected final Logger log = LoggerFactory.getLogger(XKDepartmentTask.class);
    @Autowired
    //private ITokenXkstaffDepartmentService iTokenXkstaffDepartmentService;

    public void RunDistinctVpn(){
        try {
            //iTokenXkstaffDepartmentService.deleteDistinctVpn();
        }catch (Exception e){
            log.error("定期清理开启远程表定时任务接口异常：",e);
        }

    }
}
