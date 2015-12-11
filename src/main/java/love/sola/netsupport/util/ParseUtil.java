package love.sola.netsupport.util;

import love.sola.netsupport.enums.Status;
import love.sola.netsupport.pojo.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

import static love.sola.netsupport.config.Lang.lang;

/**
 * ***********************************************
 * Created by Sola on 2015/12/11.
 * Don't modify this source without my agreement
 * ***********************************************
 */
public class ParseUtil {

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm EEE");

	public static String parseTicket(Ticket t) {
		StringBuilder sb = new StringBuilder()
				.append(lang("Ticket_Info_Id")).append(t.getId()).append("\n")
				.append(lang("Ticket_Info_Desc")).append(t.getDescription()).append("\n")
				.append(lang("Ticket_Info_Submit_Time")).append(dateFormat.format(t.getSubmitTime())).append("\n");
		if (t.getUpdateTime() != null) {
			sb.append(lang("Ticket_Info_Operator")).append(t.getOperator().getId()).append("\n");
			sb.append(lang("Ticket_Info_Remark")).append(t.getRemark()).append("\n");
			sb.append(lang("Ticket_Info_Update_Time")).append(dateFormat.format(t.getUpdateTime())).append("\n");
		}
		sb.append(lang("Ticket_Info_Status")).append(Status.getLocalized(t.getStatus()));
		return sb.toString();
	}

	public static String parseJsonP(HttpServletRequest request, String json) {
		String jsonp = request.getParameter("jsonp");
		if (jsonp == null || jsonp.isEmpty())
			return json;
		else
			return jsonp.replace("{0}", json);
	}
}