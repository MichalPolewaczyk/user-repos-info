package com.recruitment.task.userreposinfo.unit;

import com.recruitment.task.userreposinfo.domain.boundary.UserReposDetailsOutputDto;
import com.recruitment.task.userreposinfo.domain.boundary.UserReposRawDetailsDto;
import com.recruitment.task.userreposinfo.domain.exception.NotAllowedCalculationsDataException;
import com.recruitment.task.userreposinfo.domain.exception.UserReposDetailsProviderException;
import com.recruitment.task.userreposinfo.domain.port.UserReposDetailsProvider;
import com.recruitment.task.userreposinfo.domain.port.UserReposFacade;
import com.recruitment.task.userreposinfo.domain.port.UserReposRepository;
import com.recruitment.task.userreposinfo.infrastructure.config.UserReposDetailsConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserReposFacadeImplTest {

    @Mock
    private UserReposRepository repository;
    @Mock
    private UserReposDetailsProvider provider;
    private UserReposFacade facade;

    @BeforeEach
    void setUp() {
        facade = new UserReposDetailsConfig().userReposService(
                provider,
                repository
        );
    }

    @Test
    void shouldReturnValidDetailsWhenDetailsProviderProperlyReturns() {
        final String validLogin = "validLogin";

        when(provider.getDetailsOfUserWithGivenLogin(validLogin)).thenReturn(prepareRawDetailsWithLogin(validLogin));
        UserReposDetailsOutputDto outputDto = facade.getRepoDetailsOfUserWithGivenLogin(validLogin);

        assertEquals(validLogin, outputDto.login());
    }

    @Test
    void shouldThrowWhenDetailsProviderFails() {
        final String invalidLogin = "invalid";

        when(provider.getDetailsOfUserWithGivenLogin(invalidLogin)).thenThrow(UserReposDetailsProviderException.class);

        assertThrows(
                UserReposDetailsProviderException.class,
                ()->facade.getRepoDetailsOfUserWithGivenLogin(invalidLogin)
                );
    }

    @Test
    void shouldThrowWhenCanNotPerformCalculations() {
        final String validLogin = "validLogin";

        when(provider.getDetailsOfUserWithGivenLogin(validLogin)).thenThrow(NotAllowedCalculationsDataException.class);

        assertThrows(
                NotAllowedCalculationsDataException.class,
                ()->facade.getRepoDetailsOfUserWithGivenLogin(validLogin)
        );
    }

    private UserReposRawDetailsDto prepareRawDetailsWithLogin(String login) {
        return new UserReposRawDetailsDto(
                "123",
                login,
                "name",
                "type",
                "avatarUrl",
                LocalDateTime.now().minusDays(20),
                20,
                20
        );
    }
}
