package com.gmail.stefvanschiedev.buildinggame.utils.nms;

import com.gmail.stefvanschiedev.buildinggame.abstraction.NMSManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;
import java.util.Map;

/**
 * Utility class containing versioning related methods.
 *
 * @since 12.1.0
 */
public class VersionMatcher {

    /**
     * The nms managers for each version.
     */
    @NotNull
    private static final Map<Version, Class<? extends NMSManager>> NMS_MANAGERS;

    /**
     * Creates a new NMS manager instance for the current server's version.
     *
     * @return the nms manager
     * @since 12.1.0
     */
    @NotNull
    @Contract(pure = true)
    public static NMSManager createNMSManager() {
        try {
            return NMS_MANAGERS.get(Version.getVersion()).getConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException exception) {
            throw new IllegalStateException(exception);
        }
    }

    static {
        NMS_MANAGERS = new EnumMap<>(Version.class);
        NMS_MANAGERS.put(Version.V1_19_0, com.gmail.stefvanschiedev.buildinggame.nms.v1_19_0.NMSManagerImpl.class);
        NMS_MANAGERS.put(Version.V1_19_1, com.gmail.stefvanschiedev.buildinggame.nms.v1_19_1.NMSManagerImpl.class);
        NMS_MANAGERS.put(Version.V1_19_2, com.gmail.stefvanschiedev.buildinggame.nms.v1_19_2.NMSManagerImpl.class);
        NMS_MANAGERS.put(Version.V1_19_3, com.gmail.stefvanschiedev.buildinggame.nms.v1_19_3.NMSManagerImpl.class);
        NMS_MANAGERS.put(Version.V1_19_4, com.gmail.stefvanschiedev.buildinggame.nms.v1_19_4.NMSManagerImpl.class);
        NMS_MANAGERS.put(Version.V1_20_0, com.gmail.stefvanschiedev.buildinggame.nms.v1_20.NMSManagerImpl.class);
        NMS_MANAGERS.put(Version.V1_20_1, com.gmail.stefvanschiedev.buildinggame.nms.v1_20.NMSManagerImpl.class);
    }
}
