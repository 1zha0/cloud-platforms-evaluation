
package org.cloudcomputingevaluation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.cloudcomputingevaluation package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CloudComputatonEvaluationException_QNAME = new QName("http://cloudComputingEvaluation.org/", "CloudComputatonEvaluationException");
    private final static QName _Result_QNAME = new QName("http://cloudComputingEvaluation.org/", "Result");
    private final static QName _DeleteContent_QNAME = new QName("http://cloudComputingEvaluation.org/", "content");
    private final static QName _ReadDataByNumberResponseReadDataByNumberResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "ReadDataByNumberResult");
    private final static QName _InstanceResponseMessage_QNAME = new QName("http://cloudComputingEvaluation.org/", "message");
    private final static QName _CreateResponseCreateResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "CreateResult");
    private final static QName _DeleteResponseDeleteResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "DeleteResult");
    private final static QName _ResultId_QNAME = new QName("http://cloudComputingEvaluation.org/", "Id");
    private final static QName _ResultValue_QNAME = new QName("http://cloudComputingEvaluation.org/", "Value");
    private final static QName _ReadAndUpdateResponseReadAndUpdateResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "ReadAndUpdateResult");
    private final static QName _InstanceResponseResponseInstanceResponseResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "InstanceResponseResult");
    private final static QName _CreateDataByNumberResponseCreateDataByNumberResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "CreateDataByNumberResult");
    private final static QName _ReadResponseReadResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "ReadResult");
    private final static QName _DeleteDataByNumberResponseDeleteDataByNumberResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "DeleteDataByNumberResult");
    private final static QName _BigFileReceiveResponseBigFileReceiveResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "BigFileReceiveResult");
    private final static QName _UpdateDataByNumberResponseUpdateDataByNumberResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "UpdateDataByNumberResult");
    private final static QName _ReadByRangeResponseReadByRangeResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "ReadByRangeResult");
    private final static QName _UpdateOldValue_QNAME = new QName("http://cloudComputingEvaluation.org/", "oldValue");
    private final static QName _UpdateNewValue_QNAME = new QName("http://cloudComputingEvaluation.org/", "newValue");
    private final static QName _UpdateResponseUpdateResult_QNAME = new QName("http://cloudComputingEvaluation.org/", "UpdateResult");
    private final static QName _CloudComputatonEvaluationExceptionReason_QNAME = new QName("http://cloudComputingEvaluation.org/", "Reason");
    private final static QName _ReadAndUpdateId_QNAME = new QName("http://cloudComputingEvaluation.org/", "id");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.cloudcomputingevaluation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetupDefaultDataResponse }
     * 
     */
    public SetupDefaultDataResponse createSetupDefaultDataResponse() {
        return new SetupDefaultDataResponse();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link CreateDataByNumber }
     * 
     */
    public CreateDataByNumber createCreateDataByNumber() {
        return new CreateDataByNumber();
    }

    /**
     * Create an instance of {@link GetCounter }
     * 
     */
    public GetCounter createGetCounter() {
        return new GetCounter();
    }

    /**
     * Create an instance of {@link CleanDefaultData }
     * 
     */
    public CleanDefaultData createCleanDefaultData() {
        return new CleanDefaultData();
    }

    /**
     * Create an instance of {@link InstanceResponse }
     * 
     */
    public InstanceResponse createInstanceResponse() {
        return new InstanceResponse();
    }

    /**
     * Create an instance of {@link Read }
     * 
     */
    public Read createRead() {
        return new Read();
    }

    /**
     * Create an instance of {@link ResetCounter }
     * 
     */
    public ResetCounter createResetCounter() {
        return new ResetCounter();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link GetCounterResponse }
     * 
     */
    public GetCounterResponse createGetCounterResponse() {
        return new GetCounterResponse();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link ReadAndUpdateResponse }
     * 
     */
    public ReadAndUpdateResponse createReadAndUpdateResponse() {
        return new ReadAndUpdateResponse();
    }

    /**
     * Create an instance of {@link BigFileReceiveResponse }
     * 
     */
    public BigFileReceiveResponse createBigFileReceiveResponse() {
        return new BigFileReceiveResponse();
    }

    /**
     * Create an instance of {@link SetupDefaultData }
     * 
     */
    public SetupDefaultData createSetupDefaultData() {
        return new SetupDefaultData();
    }

    /**
     * Create an instance of {@link ResetCounterResponse }
     * 
     */
    public ResetCounterResponse createResetCounterResponse() {
        return new ResetCounterResponse();
    }

    /**
     * Create an instance of {@link ReadDataByNumber }
     * 
     */
    public ReadDataByNumber createReadDataByNumber() {
        return new ReadDataByNumber();
    }

    /**
     * Create an instance of {@link ReadDataByNumberResponse }
     * 
     */
    public ReadDataByNumberResponse createReadDataByNumberResponse() {
        return new ReadDataByNumberResponse();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link InstanceResponseResponse }
     * 
     */
    public InstanceResponseResponse createInstanceResponseResponse() {
        return new InstanceResponseResponse();
    }

    /**
     * Create an instance of {@link CreateDataByNumberResponse }
     * 
     */
    public CreateDataByNumberResponse createCreateDataByNumberResponse() {
        return new CreateDataByNumberResponse();
    }

    /**
     * Create an instance of {@link ReadByRange }
     * 
     */
    public ReadByRange createReadByRange() {
        return new ReadByRange();
    }

    /**
     * Create an instance of {@link ReadResponse }
     * 
     */
    public ReadResponse createReadResponse() {
        return new ReadResponse();
    }

    /**
     * Create an instance of {@link DeleteDataByNumberResponse }
     * 
     */
    public DeleteDataByNumberResponse createDeleteDataByNumberResponse() {
        return new DeleteDataByNumberResponse();
    }

    /**
     * Create an instance of {@link DeleteDataByNumber }
     * 
     */
    public DeleteDataByNumber createDeleteDataByNumber() {
        return new DeleteDataByNumber();
    }

    /**
     * Create an instance of {@link UpdateDataByNumberResponse }
     * 
     */
    public UpdateDataByNumberResponse createUpdateDataByNumberResponse() {
        return new UpdateDataByNumberResponse();
    }

    /**
     * Create an instance of {@link ReadByRangeResponse }
     * 
     */
    public ReadByRangeResponse createReadByRangeResponse() {
        return new ReadByRangeResponse();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link UpdateDataByNumber }
     * 
     */
    public UpdateDataByNumber createUpdateDataByNumber() {
        return new UpdateDataByNumber();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link BigFileReceive }
     * 
     */
    public BigFileReceive createBigFileReceive() {
        return new BigFileReceive();
    }

    /**
     * Create an instance of {@link CloudComputatonEvaluationException }
     * 
     */
    public CloudComputatonEvaluationException createCloudComputatonEvaluationException() {
        return new CloudComputatonEvaluationException();
    }

    /**
     * Create an instance of {@link CleanDefaultDataResponse }
     * 
     */
    public CleanDefaultDataResponse createCleanDefaultDataResponse() {
        return new CleanDefaultDataResponse();
    }

    /**
     * Create an instance of {@link ReadAndUpdate }
     * 
     */
    public ReadAndUpdate createReadAndUpdate() {
        return new ReadAndUpdate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloudComputatonEvaluationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "CloudComputatonEvaluationException")
    public JAXBElement<CloudComputatonEvaluationException> createCloudComputatonEvaluationException(CloudComputatonEvaluationException value) {
        return new JAXBElement<CloudComputatonEvaluationException>(_CloudComputatonEvaluationException_QNAME, CloudComputatonEvaluationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "Result")
    public JAXBElement<Result> createResult(Result value) {
        return new JAXBElement<Result>(_Result_QNAME, Result.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "content", scope = Delete.class)
    public JAXBElement<String> createDeleteContent(String value) {
        return new JAXBElement<String>(_DeleteContent_QNAME, String.class, Delete.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "ReadDataByNumberResult", scope = ReadDataByNumberResponse.class)
    public JAXBElement<Result> createReadDataByNumberResponseReadDataByNumberResult(Result value) {
        return new JAXBElement<Result>(_ReadDataByNumberResponseReadDataByNumberResult_QNAME, Result.class, ReadDataByNumberResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "message", scope = InstanceResponse.class)
    public JAXBElement<String> createInstanceResponseMessage(String value) {
        return new JAXBElement<String>(_InstanceResponseMessage_QNAME, String.class, InstanceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "CreateResult", scope = CreateResponse.class)
    public JAXBElement<Result> createCreateResponseCreateResult(Result value) {
        return new JAXBElement<Result>(_CreateResponseCreateResult_QNAME, Result.class, CreateResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "content", scope = Read.class)
    public JAXBElement<String> createReadContent(String value) {
        return new JAXBElement<String>(_DeleteContent_QNAME, String.class, Read.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "DeleteResult", scope = DeleteResponse.class)
    public JAXBElement<Result> createDeleteResponseDeleteResult(Result value) {
        return new JAXBElement<Result>(_DeleteResponseDeleteResult_QNAME, Result.class, DeleteResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "Id", scope = Result.class)
    public JAXBElement<String> createResultId(String value) {
        return new JAXBElement<String>(_ResultId_QNAME, String.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "Value", scope = Result.class)
    public JAXBElement<String> createResultValue(String value) {
        return new JAXBElement<String>(_ResultValue_QNAME, String.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "ReadAndUpdateResult", scope = ReadAndUpdateResponse.class)
    public JAXBElement<Result> createReadAndUpdateResponseReadAndUpdateResult(Result value) {
        return new JAXBElement<Result>(_ReadAndUpdateResponseReadAndUpdateResult_QNAME, Result.class, ReadAndUpdateResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "InstanceResponseResult", scope = InstanceResponseResponse.class)
    public JAXBElement<Result> createInstanceResponseResponseInstanceResponseResult(Result value) {
        return new JAXBElement<Result>(_InstanceResponseResponseInstanceResponseResult_QNAME, Result.class, InstanceResponseResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "CreateDataByNumberResult", scope = CreateDataByNumberResponse.class)
    public JAXBElement<Result> createCreateDataByNumberResponseCreateDataByNumberResult(Result value) {
        return new JAXBElement<Result>(_CreateDataByNumberResponseCreateDataByNumberResult_QNAME, Result.class, CreateDataByNumberResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "ReadResult", scope = ReadResponse.class)
    public JAXBElement<Result> createReadResponseReadResult(Result value) {
        return new JAXBElement<Result>(_ReadResponseReadResult_QNAME, Result.class, ReadResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "DeleteDataByNumberResult", scope = DeleteDataByNumberResponse.class)
    public JAXBElement<Result> createDeleteDataByNumberResponseDeleteDataByNumberResult(Result value) {
        return new JAXBElement<Result>(_DeleteDataByNumberResponseDeleteDataByNumberResult_QNAME, Result.class, DeleteDataByNumberResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "BigFileReceiveResult", scope = BigFileReceiveResponse.class)
    public JAXBElement<Result> createBigFileReceiveResponseBigFileReceiveResult(Result value) {
        return new JAXBElement<Result>(_BigFileReceiveResponseBigFileReceiveResult_QNAME, Result.class, BigFileReceiveResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "UpdateDataByNumberResult", scope = UpdateDataByNumberResponse.class)
    public JAXBElement<Result> createUpdateDataByNumberResponseUpdateDataByNumberResult(Result value) {
        return new JAXBElement<Result>(_UpdateDataByNumberResponseUpdateDataByNumberResult_QNAME, Result.class, UpdateDataByNumberResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "ReadByRangeResult", scope = ReadByRangeResponse.class)
    public JAXBElement<Result> createReadByRangeResponseReadByRangeResult(Result value) {
        return new JAXBElement<Result>(_ReadByRangeResponseReadByRangeResult_QNAME, Result.class, ReadByRangeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "oldValue", scope = Update.class)
    public JAXBElement<String> createUpdateOldValue(String value) {
        return new JAXBElement<String>(_UpdateOldValue_QNAME, String.class, Update.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "newValue", scope = Update.class)
    public JAXBElement<String> createUpdateNewValue(String value) {
        return new JAXBElement<String>(_UpdateNewValue_QNAME, String.class, Update.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "UpdateResult", scope = UpdateResponse.class)
    public JAXBElement<Result> createUpdateResponseUpdateResult(Result value) {
        return new JAXBElement<Result>(_UpdateResponseUpdateResult_QNAME, Result.class, UpdateResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "content", scope = Create.class)
    public JAXBElement<String> createCreateContent(String value) {
        return new JAXBElement<String>(_DeleteContent_QNAME, String.class, Create.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "Reason", scope = CloudComputatonEvaluationException.class)
    public JAXBElement<String> createCloudComputatonEvaluationExceptionReason(String value) {
        return new JAXBElement<String>(_CloudComputatonEvaluationExceptionReason_QNAME, String.class, CloudComputatonEvaluationException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cloudComputingEvaluation.org/", name = "id", scope = ReadAndUpdate.class)
    public JAXBElement<String> createReadAndUpdateId(String value) {
        return new JAXBElement<String>(_ReadAndUpdateId_QNAME, String.class, ReadAndUpdate.class, value);
    }

}
