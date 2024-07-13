package telran.io;

import java.io.IOException;

public interface Persistable {
	void save(String filePathStr) throws Exception;
	void restore(String filePathStr) throws IOException;
}
