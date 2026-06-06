import Catalog from "../../features/catalog/Catalog.tsx";
import {Container, createTheme, CssBaseline, ThemeProvider} from "@mui/material";
import Header from "./Header.tsx";
import {useState} from "react";

function App() {
    //define a state variable products, using useState
    const[darkMode, setDarkMode] = useState(false);
    const paletteType = darkMode ? 'dark' : 'light';

    const theme = createTheme({
        palette:{
            mode:paletteType,
        }
    })

    function handleThemeChange(){
        setDarkMode(!darkMode);
    }

  return(
      <ThemeProvider theme={theme}>
      <CssBaseline/>
      <Header darkMode={darkMode} handleThemeChange={handleThemeChange}/>
      <Container sx={{paddingTop: "65px"}}>
          <Catalog/>
      </Container>
      </ThemeProvider>
  )
}

export default App
