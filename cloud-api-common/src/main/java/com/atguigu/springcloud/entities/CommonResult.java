package com.atguigu.springcloud.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {
    private Integer code;   // 返回码
    private String massage; // 返回消息
    private T date;         // 返回数据

    /**
     * 因为返回数据不一定要有数据
     * @param code
     * @param massage
     */
    public CommonResult(Integer code,String massage) {
        this(code,massage,null);
    }
}