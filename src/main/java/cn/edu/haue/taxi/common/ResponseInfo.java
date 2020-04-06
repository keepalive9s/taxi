package cn.edu.haue.taxi.common;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseInfo {

    //layui默认返回状态码code = 0,当未授权访问时code = 1001
    private int code = 0;

    private int icon;
    //返回状态码
    private int resultCode;
    //返回信息
    private String resultMessage;

    public ResponseInfo(int code) {
        this.code = code;
    }

    public ResponseInfo(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public int getIcon() {
        if (resultCode == ResultCode.RESULT_CODE_SUCCESS) {
            return 1;
        } else {
            return 2;
        }
    }
}
