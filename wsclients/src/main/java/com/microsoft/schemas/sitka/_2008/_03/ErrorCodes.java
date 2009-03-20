
package com.microsoft.schemas.sitka._2008._03;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ErrorCodes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ErrorCodes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Success"/>
 *     &lt;enumeration value="EntityNotFound"/>
 *     &lt;enumeration value="EntityExists"/>
 *     &lt;enumeration value="InvalidEntity"/>
 *     &lt;enumeration value="EntityNotModified"/>
 *     &lt;enumeration value="InvalidContainerSpecification"/>
 *     &lt;enumeration value="UnableToCreateDnsRecord"/>
 *     &lt;enumeration value="UnableToRemoveDnsRecord"/>
 *     &lt;enumeration value="NoAuthoritySpecified"/>
 *     &lt;enumeration value="InvalidContainerQueryRequest"/>
 *     &lt;enumeration value="InvalidQueryDefinition"/>
 *     &lt;enumeration value="ServiceNotAvailable"/>
 *     &lt;enumeration value="OperationTimeout"/>
 *     &lt;enumeration value="InvalidRequest"/>
 *     &lt;enumeration value="InvalidScope"/>
 *     &lt;enumeration value="PreconditionFailed"/>
 *     &lt;enumeration value="ContentMatchFailed"/>
 *     &lt;enumeration value="SecurityError"/>
 *     &lt;enumeration value="InvalidUserId"/>
 *     &lt;enumeration value="UnknownError"/>
 *     &lt;enumeration value="UnexpectedError"/>
 *     &lt;enumeration value="ConcurrencyConflictError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ErrorCodes")
@XmlEnum
public enum ErrorCodes {

    @XmlEnumValue("Success")
    SUCCESS("Success"),
    @XmlEnumValue("EntityNotFound")
    ENTITY_NOT_FOUND("EntityNotFound"),
    @XmlEnumValue("EntityExists")
    ENTITY_EXISTS("EntityExists"),
    @XmlEnumValue("InvalidEntity")
    INVALID_ENTITY("InvalidEntity"),
    @XmlEnumValue("EntityNotModified")
    ENTITY_NOT_MODIFIED("EntityNotModified"),
    @XmlEnumValue("InvalidContainerSpecification")
    INVALID_CONTAINER_SPECIFICATION("InvalidContainerSpecification"),
    @XmlEnumValue("UnableToCreateDnsRecord")
    UNABLE_TO_CREATE_DNS_RECORD("UnableToCreateDnsRecord"),
    @XmlEnumValue("UnableToRemoveDnsRecord")
    UNABLE_TO_REMOVE_DNS_RECORD("UnableToRemoveDnsRecord"),
    @XmlEnumValue("NoAuthoritySpecified")
    NO_AUTHORITY_SPECIFIED("NoAuthoritySpecified"),
    @XmlEnumValue("InvalidContainerQueryRequest")
    INVALID_CONTAINER_QUERY_REQUEST("InvalidContainerQueryRequest"),
    @XmlEnumValue("InvalidQueryDefinition")
    INVALID_QUERY_DEFINITION("InvalidQueryDefinition"),
    @XmlEnumValue("ServiceNotAvailable")
    SERVICE_NOT_AVAILABLE("ServiceNotAvailable"),
    @XmlEnumValue("OperationTimeout")
    OPERATION_TIMEOUT("OperationTimeout"),
    @XmlEnumValue("InvalidRequest")
    INVALID_REQUEST("InvalidRequest"),
    @XmlEnumValue("InvalidScope")
    INVALID_SCOPE("InvalidScope"),
    @XmlEnumValue("PreconditionFailed")
    PRECONDITION_FAILED("PreconditionFailed"),
    @XmlEnumValue("ContentMatchFailed")
    CONTENT_MATCH_FAILED("ContentMatchFailed"),
    @XmlEnumValue("SecurityError")
    SECURITY_ERROR("SecurityError"),
    @XmlEnumValue("InvalidUserId")
    INVALID_USER_ID("InvalidUserId"),
    @XmlEnumValue("UnknownError")
    UNKNOWN_ERROR("UnknownError"),
    @XmlEnumValue("UnexpectedError")
    UNEXPECTED_ERROR("UnexpectedError"),
    @XmlEnumValue("ConcurrencyConflictError")
    CONCURRENCY_CONFLICT_ERROR("ConcurrencyConflictError");
    private final String value;

    ErrorCodes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ErrorCodes fromValue(String v) {
        for (ErrorCodes c: ErrorCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
