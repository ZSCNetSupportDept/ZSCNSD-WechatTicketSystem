package love.sola.netsupport.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import love.sola.netsupport.enums.Block;
import love.sola.netsupport.enums.BlockConverter;
import love.sola.netsupport.enums.ISP;
import love.sola.netsupport.enums.ISPConverter;

import javax.persistence.*;

/**
 * ***********************************************
 * Created by Sola on 2014/8/20.
 * Don't modify this source without my agreement
 * ***********************************************
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Column(name = "name", updatable = false, nullable = false)
	private String name;
	@Convert(converter = ISPConverter.class)
	private ISP isp;
	@Column(name = "netaccount")
	private String netAccount;
	@Column(name = "wechat")
	private String wechatId;
	@Convert(converter = BlockConverter.class)
	private Block block;
	private Integer room;
	private Long phone;

}