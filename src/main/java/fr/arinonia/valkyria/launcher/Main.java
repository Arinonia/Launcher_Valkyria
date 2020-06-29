package fr.arinonia.valkyria.launcher;

import fr.arinonia.arilibfx.utils.AriLogger;
import fr.arinonia.valkyria.launcher.files.FileManager;
import fr.arinonia.valkyria.launcher.ui.FxApplication;
import javafx.application.Application;

import javax.swing.*;
import java.beans.IntrospectionException;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Arinonia on 28/06/2020 inside the package - fr.arinonia.valkyria.launcher
 */
public class Main {

    public static final AriLogger LOGGER = new AriLogger("Valkyria");

    public static void main(String[] args) {
        new Main().init(args);
    }
    private void init(String... args){
        if(loadJavaFX()){
            LOGGER.log("JavaFX found, start application");
            Application.launch(FxApplication.class, args);
        }else{
            LOGGER.warn("JavaFX not found");
            JOptionPane.showMessageDialog(null, "Une erreur avec Java à été detéctée.\n", "Erreur-Java", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean loadJavaFX() {
        if(isJavaFXLoaded()) {
            LOGGER.log("JFX is already initialized");
            return true;
        }

        File jfxrt =  new File(FileManager.getDIR(), "runtime" + File.separator + "java" + File.separator + "jre" + File.separator + "lib" + File.separator + "ext" + File.separator + "jfxrt.jar");
        if(jfxrt.exists())
            LOGGER.log("jfxrt exist.");
        else
            LOGGER.warn("jfxrt doesn't exist !! wtf ???");
        if(jfxrt.isFile()) {
            try {
                LOGGER.log("Attempting to load {" + jfxrt + "}...");
                addToSystemClassLoader(jfxrt);
                LOGGER.log("JFX has been detected & successfully loaded.");
                return true;
            }
            catch (Throwable e) {
                LOGGER.log("JFX has been detected but unsuccessfully loaded."+ e);
                return false;
            }
        }else{

        }

        return false;
    }

    public void addToSystemClassLoader(final File file) throws IntrospectionException {
        if(ClassLoader.getSystemClassLoader() instanceof URLClassLoader) {
            final URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            try {
                final Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                method.setAccessible(true);
                method.invoke(classLoader, file.toURI().toURL());
            }
            catch (Throwable t) {
                LOGGER.log("Couldn't add " + file + " to system classloader"+ t);
            }
        }
    }

    private boolean isJavaFXLoaded() {
        try {
            this.getClass().getClassLoader().loadClass("javafx.embed.swing.JFXPanel");
            return true;
        }
        catch (ClassNotFoundException localClassNotFoundException) {
            System.out.println(localClassNotFoundException.getMessage());
            return false;
        }
    }
}
