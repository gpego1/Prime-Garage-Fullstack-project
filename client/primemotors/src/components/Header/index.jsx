import './header-style.css';
import { FaShoppingCart } from "react-icons/fa";
import { CiSearch } from "react-icons/ci";

export function Header() {
    return(
        <header className="App-header">
                <nav className='nav'>
                    <h2 className='logo'>Prime Motors</h2>
                    <ul className="menu">
                        <li><a href='/'> Home </a> </li >
                        <li><a href='/'> Products </a></li >
                        <li><a href='/'> Contact </a></li >
                        <li><a href='/'> Login </a> </li >

                        <li className='search-item'>
                            <div className='search-box'>
                                <input type='text' placeholder='What are you looking for?' className='input' />
                                <button className='search-btn' type='submit'><CiSearch /></button>
                            </div>
                        </li>

                        <li className='cart'>
                            <a href='/'> <FaShoppingCart /> </a>
                        </li >
                    </ul>

                </nav>
        </header>
    )
}