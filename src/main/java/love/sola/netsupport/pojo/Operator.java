package love.sola.netsupport.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ***********************************************
 * Created by Sola on 2015/12/6.
 * Don't modify this source without my agreement
 * ***********************************************
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operators")
public class Operator {

	@Id
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Integer id;
	@Column(name = "name", nullable = false, insertable = false, updatable = false)
	private String name;
	@Column(name = "access", nullable = false, insertable = false, updatable = false)
	private Integer access;
	@Column(name = "wechat", nullable = false, insertable = false, updatable = false)
	private String wechat;
	private Integer block;
	private Integer week;
	private String password;

}