package vn.tat.crud.tidb.exception;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import vn.tat.crud.tidb.dto.MessageInfo;
import vn.tat.crud.tidb.enumeration.MessageCodeEnum;

import java.util.Objects;

@JsonIgnoreProperties({"cause", "stackTrace"})
@Getter
public class NABException extends RuntimeException {

    private final Logger log = LoggerFactory.getLogger(NABException.class);
    protected HttpStatus httpStatus;
    protected Object[] parameters;
    protected MessageInfo messageInfo;

    /**
     * The constructor
     *
     * @param messageCode
     */
    public NABException(MessageCodeEnum messageCode, HttpStatus httpStatus) {
        this(null, messageCode, httpStatus, null);
    }

    /**
     * The constructor
     */
    public NABException(MessageCodeEnum messageCode) {
        this(null, messageCode, null, null);
    }

    /**
     * The constructor
     */
    public NABException(String code, String msg) {
        this(null, code, msg, null, null);
    }

    /**
     * The constructor
     *
     * @param cause
     * @param parameters
     */
    public NABException(Throwable cause, String code, String msg, HttpStatus httpStatus,
                        Object... parameters) {
        super(code, cause);
        this.httpStatus = httpStatus;
        this.parameters = parameters;
        this.messageInfo = buildMessageInfo(code, msg, parameters);
    }

    /**
     * The constructor
     *
     * @param cause
     * @param parameters
     */
    public NABException(Throwable cause, MessageCodeEnum messageCode, HttpStatus httpStatus,
                        Object... parameters) {
        super(messageCode.getCode(), cause);
        this.httpStatus = httpStatus;
        this.parameters = parameters;
        this.messageInfo = buildMessageInfo(messageCode, parameters);
    }

    /**
     * The constructor
     *
     * @param parameters
     */
    public NABException(MessageCodeEnum messageCode, HttpStatus httpStatus, Object... parameters) {
        super(messageCode.getCode());
        this.httpStatus = httpStatus;
        this.parameters = parameters;
        this.messageInfo = buildMessageInfo(messageCode, parameters);
    }


    /**
     * Return the message information that get from MessageSource
     *
     * @return The content of message
     */
    protected MessageInfo buildMessageInfo(String code, String msg, Object... parameters) {
        MessageInfo info = new MessageInfo();
        try {
            info.setCode(code);
            info.setMessage(String.format(msg, parameters));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return info;
    }


    /**
     * Return the message information that get from MessageSource
     *
     * @return The content of message
     */
    protected MessageInfo buildMessageInfo(MessageCodeEnum messageCode, Object... parameters) {
        MessageInfo info = new MessageInfo();
        try {
            info.setCode(messageCode.getCode());
            info.setMessage(String.format(messageCode.getMsg(), parameters));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return info;
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance (which may be {@code
     * null}).
     */
    @Override
    public String getMessage() {
        if (Objects.isNull(messageInfo)) {
            return super.getMessage();
        } else {
            return messageInfo.getMessage();
        }
    }
}
