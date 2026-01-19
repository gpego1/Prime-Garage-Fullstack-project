import './staticList-styles.css'

export function StaticList() {
    return (
        <nav className="sidebar-menu">
        <ul className='static-list'>
            <li className="menu-item"><a href='/'>Audi</a></li>
            <li className="menu-item"><a href='/'>BMW</a></li>
            <li className="menu-item"><a href='/'>BYD</a></li>
            <li className="menu-item"><a href='/'>Hyundai</a></li>
            <li className="menu-item"><a href='/'>Kia</a></li>
            <li className="menu-item"><a href='/'>Mercedes</a></li>
            <li className="menu-item"><a href='/'>Chevrolet</a></li>
            <li className="menu-item"><a href='/'>Toyota</a></li>
            <li className="menu-item"><a href='/'>Nissan</a></li>
        </ul>
        </nav>
    )
}