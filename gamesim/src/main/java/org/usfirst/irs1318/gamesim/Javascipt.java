package org.usfirst.irs1318.gamesim;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

public final class Javascipt {
    public static Object eval(String string, Map<String, Object> env) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        env.forEach(engine::put);

        return engine.eval(string);
    }
}
