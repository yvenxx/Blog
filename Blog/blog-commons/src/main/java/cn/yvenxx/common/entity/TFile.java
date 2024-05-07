package cn.yvenxx.common.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yven
 * @since 2024-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TFile implements Serializable {

    private static final long serialVersionUID = 1L;

    private String originName;

    private String name;

    private String path;


}
