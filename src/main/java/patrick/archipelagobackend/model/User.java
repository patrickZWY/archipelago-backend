package patrick.archipelagobackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;

    private String email;
    private String password;
    private String username;

    private LocalDateTime creationTime;
    private LocalDateTime updateTime;

    @Builder.Default
    private boolean deleted = false;

    protected void setUpdate() {
        this.updateTime = LocalDateTime.now();
    }

    protected void onCreate() {
        this.creationTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }

}
