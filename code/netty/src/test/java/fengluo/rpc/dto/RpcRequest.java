package fengluo.rpc.dto;

import lombok.*;

/**
 * @Author: fengluo
 * @Date: 2022/8/1 21:49
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
