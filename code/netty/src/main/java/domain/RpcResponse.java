package domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fengluo
 * @Date: 2022/7/28 20:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RpcResponse {

    private String message;

}
