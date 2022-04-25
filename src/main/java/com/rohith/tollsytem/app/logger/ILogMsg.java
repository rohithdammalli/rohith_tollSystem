package com.rohith.tollsytem.app.logger;

/**
 * 
 * 
 * ILogMsg: Logger message formats
 *
 */
public interface ILogMsg {
	public static final String pageStart = "Start page {}";
	public static final String pageEnd = "End page {} | {} sec";
	public static final String methodStart = "Start method {}";
	public static final String methodEnd = "End method {}";
	public static final String repoStart = "Start REPO {}";
	public static final String repoEnd = "End REPO {}";
	public static final String serviceStart = "Start service {}";
	public static final String serviceEnd = "End servcie {} | {} sec";
	public static final String exeMsg = "Exeption Msg - {}";
	public static final String errorMsg = "Error Msg - {}";
	public static final String resultsEnd = "Results processed in {} sec";
}
