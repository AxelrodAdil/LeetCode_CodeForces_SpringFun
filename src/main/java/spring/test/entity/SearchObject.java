package spring.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchObject {

    private String key;
    private Object value;
    private SearchOperation operation;
}
