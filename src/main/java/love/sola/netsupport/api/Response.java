package love.sola.netsupport.api;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * ***********************************************
 * Created by Sola on 2015/11/5.
 * Don't modify this source without my agreement
 * ***********************************************
 */
@AllArgsConstructor
public class Response {

	public int code;
	public String info;
	public Object result;

	public Response(ResponseCode code) {
		this(code, null);
	}

	public Response(ResponseCode code, Object result) {
		this.code = code.id;
		this.info = code.name();
		this.result = result;
	}


	public enum ResponseCode {

		ALREADY_SUBMITTED(1),
		OK(0),
		PARAMETER_REQUIRED(-1),
		ILLEGAL_PARAMETER(-2),
		REQUEST_FAILED(-3),
		LENGTH_LIMIT_EXCEEDED(-4),
		USER_NOT_FOUND(-11),
		TICKET_NOT_FOUND(-12),
		OPERATOR_NOT_FOUND(-13),
		UNAUTHORIZED(-20),
		WRONG_PASSWORD(-22),
		PERMISSION_DENIED(-24),
		INTERNAL_ERROR(-90),
		DATABASE_ERROR(-91),
		;

		private static final Map<Integer, ResponseCode> ID_MAP = new HashMap<>();

		static {
			for (ResponseCode type : values()) {
				ID_MAP.put(type.id, type);
			}
		}

		public final int id;

		ResponseCode(int id) {
			this.id = id;
		}

		public static ResponseCode fromId(int id) {
			return ID_MAP.get(id);
		}

		@Override
		public String toString() {
			return name();
		}

	}

}