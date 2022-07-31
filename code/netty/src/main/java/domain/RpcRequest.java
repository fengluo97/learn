package domain;

import lombok.*;

/**
 * @Author: fengluo
 * @Date: 2022/7/28 20:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RpcRequest {

    private String interfaceName;

    private String methodName;

}
