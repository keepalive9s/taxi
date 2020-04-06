package cn.edu.haue.taxi.common;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {
    //layui默认返回状态码code = 0,当未授权访问时code = 1001
    private int code = 0;

    private int icon;
    //layui分页需要字段
    private long count;
    //返回状态码
    private int resultCode;
    //返回信息
    private String resultMessage;
    //返回数据
    private T data;

    public ResponseData(long count, T data) {
        this.count = count;
        this.data = data;
    }

    public ResponseData(int resultCode, T data) {
        this.resultCode = resultCode;
        this.data = data;
    }

    public ResponseData(int resultCode, String resultMessage, T data) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.data = data;
    }

    public ResponseData(long count, int resultCode, String resultMessage, T data) {
        this.count = count;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getIcon() {
        if (resultCode == ResultCode.RESULT_CODE_SUCCESS) {
            return 1;
        } else {
            return 2;
        }
    }
}
