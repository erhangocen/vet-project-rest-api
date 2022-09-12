package veterinerProject.w34.bussiness.abstracts;

import veterinerProject.w34.core.results.DataResult;
import veterinerProject.w34.core.results.Result;
import veterinerProject.w34.entities.concretes.Vet;

import java.util.List;

public interface VetService {
    Result add(Vet vet);
    Result update(Vet vet);
    Result delete(Vet vet);

    DataResult<List<Vet>> getAll();
}
