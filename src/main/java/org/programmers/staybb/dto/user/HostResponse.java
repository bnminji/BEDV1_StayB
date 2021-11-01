package org.programmers.staybb.dto.user;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.programmers.staybb.domain.user.Host;

@Getter
public class HostResponse {

    private String name;

    private boolean isSuperhost;

    private List<Long> roomIds;

    protected HostResponse() {
    }

    @Builder
    public HostResponse(String name, boolean isSuperhost, List<Long> roomIds) {
        this.name = name;
        this.isSuperhost = isSuperhost;
        this.roomIds = roomIds;
    }

    public static HostResponse of(Host entity, String userName, List<Long> roomIds) {
        return HostResponse.builder()
            .name(userName)
            .isSuperhost(entity.is_superHost())
            .roomIds(roomIds)
            .build();
    }
}