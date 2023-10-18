package com.example.batoiflix.modelo.controladores;

import com.example.batoiflix.modelo.entities.Usuario;
import com.example.batoiflix.modelo.enums.TipoUsuario;
import com.example.batoiflix.modelo.repositorios.RepositoriosUsuarios;
import com.example.batoiflix.services.PasswordHelper;
import com.example.batoiflix.utils.Validator;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UsuarioController {
    private final String LOGGED_USER_KEY  = "usuarioLogged";

    @Autowired
    RepositoriosUsuarios repositoriosUsuarios;
    @Autowired
    private PasswordHelper passwordHelper;

    @GetMapping("/login")
    public String registrerUsuario(){
        return "login-registrer";
    }

    @PostMapping("/login-usuario")
    public String loginUsuario(@RequestParam Map<String, String> parms, RedirectAttributes redirectAttributes,
                                   HttpSession httpSession){
        String email = parms.get("email-login");
        String password = parms.get("password-login");
        HashMap<String,String> errores = datosUsuarioViejoValidos(email ,password);

        if (errores.size() == 0){
            httpSession.setAttribute(LOGGED_USER_KEY, repositoriosUsuarios.findByUsuario(email));
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("errores", errores);
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logoutAction(HttpSession httpSession) {
        httpSession.removeAttribute(LOGGED_USER_KEY);
        return "redirect:/";
    }

    @PostMapping("/registrer-usuario")
    public String registrerUsuario(@RequestParam Map<String, String> parms, RedirectAttributes redirectAttributes){
        String nombre = parms.get("nombre");
        String apellidos = parms.get("apellidos");
        String email = parms.get("email");
        String contrasenya = parms.get("password");
        HashMap<String,String> errores = datosUsuarioNuevoValidos(nombre,apellidos,email,contrasenya);
        contrasenya = passwordHelper.generateSha1(contrasenya);

        if (errores.size() == 0){
            HashMap<String,String> registro = new HashMap<>();
            if(repositoriosUsuarios.save(new Usuario(nombre, apellidos, email, contrasenya, TipoUsuario.USUARIO))){
                registro.put("Registro", nombre + " has sido registrado con éxito");
                redirectAttributes.addFlashAttribute("registro",registro);
                return "redirect:/login?mode=login";
            }
        }else{
            redirectAttributes.addFlashAttribute("errores",errores);
        }

        return "redirect:/login";
    }

    @GetMapping("/detalles-usuario")
    public String detallesUsuario(HttpSession httpSession, Model model){
        Usuario usuario = (Usuario) httpSession.getAttribute(LOGGED_USER_KEY);

        if(usuario != null){
            model.addAttribute("usuario", usuario);
            return "detalles-usuario";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/editar-usuario")
    public String editarUsuario(HttpSession httpSession, Model model){
        Usuario usuario = (Usuario) httpSession.getAttribute(LOGGED_USER_KEY);

        if(usuario != null){
            model.addAttribute("usuario", usuario);
            return "editar-usuario";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/cambiar-contraseña")
    public String cambiarContraseña(@RequestParam Map<String, String> parms, HttpSession httpSession, RedirectAttributes redirectAttributes) {
        Usuario usuario = (Usuario) httpSession.getAttribute(LOGGED_USER_KEY);
        String nombre = parms.get("nombre");
        String apellidos = parms.get("apellidos");
        String contrasenyaAntigua = parms.get("contrasenyaAntigua");
        String contrasenyaNueva = parms.get("contrasenyaNueva");
        String contrasenyaNueva2 = parms.get("contrasenyaNueva2");
        HashMap<String,String> errores = datosContrasenyaValidos(usuario, contrasenyaAntigua, contrasenyaNueva, contrasenyaNueva2);

        if (errores.size() == 0){
            if (!nombre.equalsIgnoreCase("")) {
                usuario.setNombre(nombre);
            }
            if (!apellidos.equalsIgnoreCase("")) {
                usuario.setApellidos(apellidos);
            }
            if (!contrasenyaNueva.equalsIgnoreCase("")) {
                usuario.setContrasenyaHash(passwordHelper.generateSha1(contrasenyaNueva));
            }
            repositoriosUsuarios.save(usuario);
            return "redirect:/detalles-usuario";
        }else{
            redirectAttributes.addFlashAttribute("errores",errores);
            return "redirect:/editar-usuario";
        }
    }

    private HashMap<String, String> datosContrasenyaValidos(Usuario usuario, String contrasenyaAntigua, String contrasenyaNueva, String contrasenyaNueva2){
        HashMap<String, String> errors = new HashMap<>();

        if(contrasenyaAntigua.equalsIgnoreCase("") || !passwordHelper.verify(contrasenyaAntigua, usuario.getContrasenyaHash())){
            errors.put("Contrasenya antigua", "La contraseña no es válida");
        }

        if(!contrasenyaNueva.equalsIgnoreCase("") && !Validator.isValidPassword(contrasenyaNueva)){
            errors.put("Contraseña nueva","La contraseña tiene que cumplir con los requisitos");
        }

        if(!contrasenyaNueva.equalsIgnoreCase("") && !contrasenyaNueva2.equalsIgnoreCase("") &&
                !contrasenyaNueva.equalsIgnoreCase(contrasenyaNueva2)){
            errors.put("Contrasenya nueva", "No coinciden las nuevas contraseñas");
        }
        return errors;
    }

    private HashMap<String,String> datosUsuarioNuevoValidos(String nombre, String apellidos, String email, String contrasenya){
        HashMap<String, String> errors = new HashMap<>();
        if (!Validator.isValidEmail(email)){
            errors.put("Email","El email no es válido");
        }
        if (!Validator.isValidPassword(contrasenya)){
            errors.put("Contraseña","La contraseña tiene que cumplir con los requisitos, debe contener mayúsculas, números y símbolos");
        }
        if (repositoriosUsuarios.findByEmail(email) != null){
            errors.put("Email","El email ya está registrado");
        }
        return errors;
    }

    private HashMap<String,String> datosUsuarioViejoValidos(String buscador, String contrasenya){
        HashMap<String, String> errors = new HashMap<>();
        Usuario usuario = repositoriosUsuarios.findByUsuario(buscador);

        if(usuario == null || !passwordHelper.verify(contrasenya, usuario.getContrasenyaHash())){
            errors.put("contrasenya", "Este usuario no existe o la contraseña no es válida");
        }
        return errors;
    }
}