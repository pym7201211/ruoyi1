package com.ruoyi.ruoyiforts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FortDetailedListService {

    public boolean selectButton(String json) throws Exception;

    public boolean sendMessageClaim(String json,String buttonType) throws Exception;

    public HashMap<String,String> selectApporvalStaus(String json) throws Exception;

    public Map<String,String> approvalProcess(String json) throws Exception;

    public String selectIsApproval(String json);

    public List<HashMap<String,String>> getIdAndName(String systemName);

}
