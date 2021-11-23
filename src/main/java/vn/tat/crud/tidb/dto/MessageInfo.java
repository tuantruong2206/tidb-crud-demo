package vn.tat.crud.tidb.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.tat.crud.tidb.enumeration.MessageCodeEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageInfo {

    private String code;
    private String message;

    public MessageInfo(MessageCodeEnum messageCodeEnum) {
        this.code = messageCodeEnum.getCode();
        this.message = messageCodeEnum.getMsg();
    }
}
