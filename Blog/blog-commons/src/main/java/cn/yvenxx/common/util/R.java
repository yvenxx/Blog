package cn.yvenxx.common.util;

import cn.yvenxx.common.constant.HttpStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class R implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public static R succ(Object data){
        R r = new R();
        r.setCode(HttpStatus.SUCCESS);
        r.setData(data);
        r.setMsg("操作成功");
        return r;
    }
    public static R succ(String mess,Object data){
        R r = new R();
        r.setCode(HttpStatus.SUCCESS);
        r.setData(data);
        r.setMsg(mess);
        return r;
    }
    public static R fail(String mess){
        R r = new R();
        r.setCode(HttpStatus.NOT_FOUND);
        r.setData(null);
        r.setMsg(mess);
        return r;
    }
    public static R fail(String mess,Object data){
        R r = new R();
        r.setCode(HttpStatus.NOT_FOUND);
        r.setData(data);
        r.setMsg(mess);
        return r;
    }
}



