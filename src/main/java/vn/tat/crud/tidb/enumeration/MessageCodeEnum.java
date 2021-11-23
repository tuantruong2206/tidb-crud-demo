package vn.tat.crud.tidb.enumeration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum MessageCodeEnum {

    COMMON_ERROR_001("common.info.001", "Your parameters are invalid"),
    COMMON_ERROR_401("common.info.401", "UnAuthoried"),
    COMMON_ERROR_017("common.info.017", "Error on field '%s' with value [%s]"),
    COMMON_ERROR_018("common.info.018", "Error on field '%s': %s"),
    COMMON_ERROR_019("common.info.019", "Access is denied"),
    COMMON_ERROR_500("common.error.500", "Internal Server Error"),
    COMMON_ERROR_020("common.error.020", "RequestHeaderDTO is null");

    private String code;
    private String msg;

    MessageCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
