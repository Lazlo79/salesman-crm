package br.com.kproj.salesman.assistants.activities2.domain.model.user;


import br.com.kproj.salesman.infrastructure.model.ModelIdentifiable;
import com.trex.shared.annotations.Model;

@Model
public class Owner extends ModelIdentifiable {

    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
