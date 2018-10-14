package mx.com.example.ws.response;

public class ObjectResponse {
	private int code;
	private String msgError;

	/**
	 * 
	 */
	public ObjectResponse() {
		super();
	}
	/**
	 * @param code
	 * @param msgError
	 */
	public ObjectResponse(int code, String msgError) {
		super();
		this.code = code;
		this.msgError = msgError;
	}
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the msgError
	 */
	public String getMsgError() {
		return msgError;
	}
	/**
	 * @param msgError the msgError to set
	 */
	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("ObjectResponse [code=");
		builder.append(code);
		builder.append(", msgError=");
		builder.append(msgError);
		builder.append("]");
	
		return builder.toString();
	}
}
