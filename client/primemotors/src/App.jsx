//import { useState } from 'react'
import './App.css'
import {Header} from "./components/Header/index.jsx";
import {PromoHeader} from "./components/PromoHeader/index.jsx";
import {CardPromo} from "./components/CardPromo/index.jsx";
import {Footer} from "./components/Footer/index.jsx";
import {StaticList} from "./components/StaticList/index.jsx";
import {CardItems} from "./components/CardItems/index.jsx";

function App() {

  return (
      <div className="container">
        <PromoHeader />
        <Header />

          <div className="layout">
              <StaticList />
              <div className="banner-wrapper">
                  <CardPromo />
              </div>
          </div>

          {/*<RegisterForm username={"user2@email.com"} password={"user123"} />*/}
            <CardItems />
          <hr />
          <Footer />
      </div>
  )
}

export default App
