package cn.gov.chinatax.gt4.swrdsm.util.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Value、label 的键值对
 *
 * @author huax
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValueLabel<K, V> implements Serializable{

    private K value;
    private V label;

}
