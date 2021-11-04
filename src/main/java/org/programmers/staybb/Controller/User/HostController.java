package org.programmers.staybb.controller.user;

import org.programmers.staybb.dto.user.HostResponse;
import org.programmers.staybb.global.exception.EntityNotFoundException;
import org.programmers.staybb.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/host")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<Long> addHost(final @PathVariable long userId)
        throws EntityNotFoundException {
        return ResponseEntity.ok(hostService.addHost(userId));
    }

    @GetMapping("/{hostId}")
    public ResponseEntity<HostResponse> getHost(final @PathVariable long hostId)
        throws EntityNotFoundException {
        return ResponseEntity.ok(hostService.findHost(hostId));
    }
}
