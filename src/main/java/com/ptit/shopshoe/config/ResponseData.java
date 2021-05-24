package com.ptit.shopshoe.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResponseData {
    String message;
    Object data;
    String code;
    public  static  ResponseData ofSuccess(Object data){
       return new ResponseData().setCode("0").setMessage("Thành công").setData(data);
    }

    public  static  ResponseData ofOk(){
        return new ResponseData().setCode("0").setMessage("Thành công");
    }

    public  static  ResponseData ofFailure(){
        return new ResponseData().setCode("1").setMessage("Thành công");
    }


}
