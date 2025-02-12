package com.example.reactboard.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
@JsonPropertyOrder({"code" , "message" , "load" , "log"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ApiResult<T> {


    @ApiModelProperty(value = "결과 코드")
    ApiResultCode code;

    @ApiModelProperty(value = "결과 메세지")
    String message;

    @ApiModelProperty(value ="로그")
    String log;

    @ApiModelProperty(value = "요청 결과")
    T load;

    public ApiResult() {
        this.code = ApiResultCode.succeed;
    }

    public ApiResult(ApiResultCode code) {
        this.code = code;
    }

    public ApiResult (ApiResultCode code , String message , T load){
        this.code = code;
        this.message = message;
        this.load = load;
    }

    public ApiResult (ApiResultCode code , String message ){
        this.code = code;
        this.message = message;
    }

    public ApiResult(T laod) {
        this.code = ApiResultCode.succeed;
        this.load = load;
    }
}
