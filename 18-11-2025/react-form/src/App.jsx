import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import RegisterForm from './RegisterForm'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="app-root">
      <header>
        <h1>Registration Form</h1>
      </header>
      <main>
        <RegisterForm />
      </main>
    </div>
  )
}

export default App
