import { defineConfig, loadEnv } from 'vite'
import react from '@vitejs/plugin-react'
import dotenv from 'dotenv'

dotenv.config();

export default defineConfig(({mode}) => {
  const env = loadEnv(mode, process.cwd(), "");

  return {
    plugins: [react()],
    server: {
      proxy: {
        '/auth': {
          target: env.VITE_SERVER_URL || 'http://localhost:5000',
          changeOrigin: true,
          secure: false,
        }
      }
    }
  }
})
