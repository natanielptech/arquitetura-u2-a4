package br.com.aula.hexagonal.framework;

import br.com.aula.hexagonal.application.ProcessarNovoPedidoService;
import br.com.aula.hexagonal.application.ports.in.ProcessarNovoPedidoUseCase;
import br.com.aula.hexagonal.application.ports.out.PedidoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    ProcessarNovoPedidoUseCase processarNovoPedidoUseCase(PedidoRepository repository) {
        return new ProcessarNovoPedidoService(repository);
    }
}
