package pl.iseebugs.module;

import pl.iseebugs.module.projection.ModuleFlagDTO;
import pl.iseebugs.module.Module;

import java.util.List;

interface ModulePort {
    //Guests
    List<Module> findAllPublic();
    Module findPublicByName(String name);

    //Users
    List<Module> findAllForUser(String username);
    Module findByName(String name, String username);
    Module findByNameForUsers(String username, String name);
    void delete(String name, String username);
    Module save(Module module, String username);
    Module update(Module module, String username);

    //Admin
    List<Module> findAllNotPrivate(String username);
    Module findByNameNotPrivate(String name, String username);
    void deleteNotPrivate(String name, String username);
    Module saveNotPrivate(Module module);
    Module updateNotPrivate(Module module);
    Module changeFlags(ModuleFlagDTO flags, String username);
}
