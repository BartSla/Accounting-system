package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperProvider {

    private static final ObjectMapper mapper = new ObjectMapper();

    public ObjectMapper mapperProvider(){
        return mapper;
    }
}
